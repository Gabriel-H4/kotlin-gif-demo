class Store2 {

    val storeNumber = 3505
    var allOrders = ArrayList<Order2>()
    var allToteIDs = ArrayList<Int>()

    fun assignOSN(): Int {
        var newOSN = 1010000
        for(order in allOrders) {
            if(order.osn >= newOSN) {
                newOSN += 1
            }
        }
        return newOSN
    }

    fun assignToteID(): Int {
        var newToteID = IntRange(10000, 99999).random()
        for(toteID in allToteIDs) {
            if(toteID >= newToteID) {
                newToteID = IntRange(10000, 99999).random()
            }
        }
        allToteIDs.add(newToteID)
        return newToteID
    }

    fun getOrdersFromPredicate(pastOnly: Boolean): ArrayList<Order2> {
        var result = ArrayList<Order2>()
        for(order in allOrders) {
            if(pastOnly) {
                if(!order.status.active) {
                    result.add(order)
                }
            }
            else {
                if(order.status.active) {
                    result.add(order)
                }
            }
        }
        return result
    }

    fun getOSNFromPredicate(pastOnly: Boolean): ArrayList<Int> {
        var result = ArrayList<Int>()
        for(order in getOrdersFromPredicate(pastOnly)) {
            result.add(order.osn)
        }
        return result
    }

    fun getCustomerList(pastOnly: Boolean): ArrayList<Customer2> {
        var result = ArrayList<Customer2>()
        for(order in getOrdersFromPredicate(pastOnly)) {
            result.add(order.customer)
        }
        return result
    }

}