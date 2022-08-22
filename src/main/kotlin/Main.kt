fun main() {

    val curStore = Store()
    val sys = InputHandler(curStore)

    val carol = Customer("Carol Danvers", "1-(217)-891-2123")
    val sterling = Customer("Sterling Archer", "1-(800)-266-2562")

    carol.placeOrder(curStore)
    carol.placeOrder(curStore)
    carol.getMyOrders(curStore)[0].changeOrderStatus(Order.OrderStatus.DISPENSED)
    sterling.placeOrder(curStore)
    sterling.getMyOrders(curStore)[0].changeOrderStatus(Order.OrderStatus.CANCELLED)
    carol.getMyOrders(curStore)[1].changeOrderStatus(Order.OrderStatus.READY)

//    Generate 10 random Tote IDs for debug

//    for(i in IntRange(1, 10)) {
//        val id = curStore.assignToteID()
//        println("$i - $id ")
//    }

    sys.runLoop()

}
