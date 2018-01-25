package rewards

class CustomerController {
    static scaffold = Customer

    def calculationService

    /*def index() {
        *//*params.max  = 5
        [customerInstanceList: Customer.list(params), customerInstanceCount: Customer.count()]*//*
    }*/

    /*def create() {
        [customerInstance: new Customer()]
    }*/



    def checkin() {
    }

    def lookup(){
        //def customerInstance = Customer.findAllByFirstNameLikeAndTotalPointsBetween("B%", 2, 3, [sort: "totalPoints", order: "asc"])
        [customerInstanceList: Customer.list()]
    }

    def customerLookup(Customer lookupInstance) {
        def (customerInstance, welcomeMessage) = calculationService.processCheckin(lookupInstance);

        render(view: "checkin", model: [customerInstance: customerInstance, welcomeMessage: welcomeMessage])
    }

    def profile() {
        def customerInstanse = Customer.findByPhone(params.id)
        [customerInstance: customerInstanse]
    }

    def updateProfile(Customer customerInstance) {
        customerInstance.save()
        render(view: "profile", model: [customerInstance: customerInstance])
    }
}
