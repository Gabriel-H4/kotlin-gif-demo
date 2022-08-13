class Customer2(val name: String, val tel: String) {

    fun getMyOrders(store: Store2): ArrayList<Order2> {
        var myOrders = ArrayList<Order2>()
        for(order in store.allOrders) {
            if(order.customer == this) {
                myOrders.add(order)
            }
        }
        return myOrders
    }

    fun placeOrder(store: Store2) {
        val newOrder = Order2(store, this)
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