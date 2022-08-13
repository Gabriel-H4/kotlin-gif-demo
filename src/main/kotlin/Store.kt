class Store {

    val storeNumber = 3505
    var activeOrders = ArrayList<Order>()
    var pastOrders = ArrayList<Order>()
    var allToteIDs = ArrayList<Int>()

    private fun genOrderNumber() : Int {
        var num = 1000000
        for(order in activeOrders) {
            if(order.osn >= num) {
                num = order.osn + 1
            }
        }
        return num
    }

    fun genToteID(): Int {
        var id = 10000
        while(allToteIDs.contains(id)) {
            id = IntRange(10000, 99999).random()
        }
        allToteIDs.add(id)
        println("Generated toteID: $id")
        return id
    }

    fun migratePastOrders() {
        activeOrders.forEach {
            if(it.status == OrderStatus.DISPENSED || it.status == OrderStatus.CANCELLED) {
                pastOrders.add(it)
            }
        }
        pastOrders.forEach {
            if(activeOrders.contains(it)) {
                activeOrders.remove(it)
            }
        }
    }

    private fun changeOrderStatus(order: Order, status: OrderStatus) {
        val pos = activeOrders.indexOf(order)
        if(pos > activeOrders.count() - 1 || pos < 0) {
            println("Invalid position in activeOrders array")
        }
        else {
            activeOrders[pos].status = status
        }
    }

    fun placeOrder(customer: Customer): Order {
        val newOrder = Order(genOrderNumber(), customer)
        newOrder.toteIDs.add(genToteID())
        activeOrders.add(newOrder)
        return newOrder
    }

    fun markOrderReady(order: Order) {
        changeOrderStatus(order, OrderStatus.READY)
    }

    fun markOrderDispensed(order: Order) {
        changeOrderStatus(order, OrderStatus.DISPENSED)
        migratePastOrders()
    }

    fun markOrderCancelled(order: Order) {
        changeOrderStatus(order, OrderStatus.CANCELLED)
        migratePastOrders()
    }
}