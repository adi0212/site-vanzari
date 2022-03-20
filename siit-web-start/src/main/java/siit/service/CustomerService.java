package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.CustomerDao;
import siit.model.Customer;
import siit.personal_errors.IncorrectNameException;
import siit.personal_errors.IncorrectPhoneNumberException;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private OrderService orderService;

    public void update(Customer customer) throws IncorrectNameException, IncorrectPhoneNumberException {

        if (verifyName(customer.getName())) {
            if(verifyPhoneNumber(customer.getPhone())) {
                customerDao.update(customer);

            }else {
                throw new IncorrectNameException("Incorrect phone number");
            }
        } else {
            throw new IncorrectPhoneNumberException("Incorrect name");

        }

    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getBy(int id) {
        Customer customer = customerDao.getBy(id); // fara orders
        customer.setOrders(orderService.getBy(id));
        return customer;
    }

    private boolean verifyName (String name){
        String newName = "";
        String[] stringName = name.split(" ");
        if (stringName.length < 1){
            return false;
        }
        if (stringName[0].equals("")){
            return false;
        }
        for (String s : stringName) {
            char[] charName = s.toCharArray();

            for (char c : charName) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            }

            charName[1] = Character.toUpperCase(charName[1]);// all names start with big letter
            newName = Arrays.toString(charName) + " ";

        }
        name = newName;
        return true;
    }

    private boolean verifyPhoneNumber (String phoneNumber){
        char [] phone = phoneNumber.toCharArray();
        if(phone[0] != '+'){
            phone.clone();
            phoneNumber = "+" + phoneNumber;
            phone = phoneNumber.toCharArray();
        }
        for (int i = 1; i < phone.length; i++){
            if (!Character.isDigit(phone[i])){
                return false;
            }
        }
        return phone.length <= 11;
    }

}
