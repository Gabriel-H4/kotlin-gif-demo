fun main() {

    val curStore = Store2()
    val sys = InputHandler2(curStore)

    val carol = Customer2("Carol Danvers", "1-(217)-891-2123")
    val sterling = Customer2("Sterling Archer", "1-(800)-266-2562")

    sys.greet()

    carol.placeOrder(curStore)
    carol.placeOrder(curStore)
    carol.getMyOrders(curStore)[0].changeOrderStatus(Order2.OrderStatus2.DISPENSED)
    sterling.placeOrder(curStore)
    sterling.getMyOrders(curStore)[0].changeOrderStatus(Order2.OrderStatus2.CANCELLED)
    carol.getMyOrders(curStore)[1].changeOrderStatus(Order2.OrderStatus2.READY)

//    Generate 10 random Tote IDs for debug

//    for(i in IntRange(1, 10)) {
//        val id = curStore.genToteID()
//        println("$i - $id ")
//    }

    sys.mainMenu()

    sys.leave()
}
