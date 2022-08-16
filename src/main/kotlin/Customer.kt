class Customer(private val name: String, private val tel: String) {

    fun getMyOrders(store: Store): ArrayList<Order> {
        var myOrders = ArrayList<Order>()
        for(order in store.allOrders) {
            if(order.customer == this) {
                myOrders.add(order)
            }
        }
        return myOrders
    }

    fun placeOrder(store: Store) {
        val newOrder = Order(store, this)
        newOrder.addNewTote()
        store.allOrders.add(newOrder)
    }

    override fun toString(): String {
        return  """
                Name: $name
                Phone: $tel
                """
    }

}