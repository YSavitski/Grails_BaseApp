package rewards

import grails.gorm.transactions.Transactional

@Transactional
class CalculationService {

    def serviceMethod() {

    }

    def processCheckin(lookupInstance) {
        def customerInstance = Customer.findByPhone(lookupInstance.phone)
        if (customerInstance == null) {
            customerInstance = lookupInstance
            customerInstance.firstName = "Customer"
        }

        def totalPoints = 0
        customerInstance.awards.each {
            if (it != null) {
                totalPoints += it.points
            }
        }
        customerInstance.totalPoints = totalPoints

        def welcomeMessage = constructWelcomeMessage(customerInstance.firstName, customerInstance.totalPoints)

        if (customerInstance.totalPoints < 5) {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }

        customerInstance.save()

        return [customerInstance, welcomeMessage]
    }

    def constructWelcomeMessage(String firstName, Integer points) {
        def welcomeMessage
        switch (points) {
            case 5:
                welcomeMessage = "Welcome back, $firstName!\nThis drink is on us."
                break
            case 4:
                welcomeMessage = "Welcome back, $firstName!\nYour next drink is free."
                break
            case 2..3:
                welcomeMessage = "Welcome back, $firstName!\nYou now have $points points."
                break
            default:
                welcomeMessage = "Welcome back, $firstName!\nThank you for registering."
        }
        return welcomeMessage
    }
}
