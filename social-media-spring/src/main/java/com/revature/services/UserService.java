package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Deprecated
    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> findByUsernameCredentials(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    
    public User save(User user) {
        return userRepository.save(user);
    }
    
    
    /**
     * Change the birthday of the user in the database
     * @param user the model of the user
     * @param newDay the day in which the user wants to change their birthday to
     * @param newMonth the month in which user wants to change their birthday to
     * @param newYear the year in which the user wants to change their birthday to
     * @return
     */
    public String changeDoB(User user, String newDay, String newMonth, String newYear) {
    	
    	user.setBirthDay(newDay);
    	user.setBirthMonth(newMonth);
    	user.setBirthYear(newYear);
    	
		LocalDate currentDate = LocalDate.now();

		
			// Individual cases for each month
			switch (newMonth) {

				case ("1"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 31) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;
				
				//accounting for leap year
				case ("2"):
					if (new GregorianCalendar().isLeapYear(Integer.parseInt(newYear))) {
						if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 29) {
							userRepository.save(user);
							return "Birthday Changed";
						}
					} else {
						if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 28) {
							userRepository.save(user);
							return "Birthday Changed";
						}
					}
					break;

				case ("3"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 31) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("4"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 30) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("5"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 31) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("6"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 30) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("7"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 31) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("8"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 31) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("9"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 30) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("10"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 31) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("11"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 30) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				case ("12"):
					if (Integer.parseInt(newDay) >= 1 && Integer.parseInt(newDay) <= 31) {
						userRepository.save(user);
						return "Birthday Changed";
					}
					break;

				default:
					return "Invalid Date";
			}

		return "Invalid Date";
    	
    }
    
    
    /**
     * Change the user's profile picture
     * @param user the user model of the logged in user
     * @param newPicture the new picture for the user
     * @return a string stating if the picture has changed
     */
    public String changeProfilePicture(User user, String newPicture) {
    	
    	user.setProfilePic(newPicture);
    	
    	try {
    		userRepository.save(user);
    		return "Picture Changed";
    		
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	
		return "Picture not Changed";
    	
    }
    
}
