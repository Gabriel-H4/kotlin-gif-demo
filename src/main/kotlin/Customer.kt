class Customer(val name: String, val tel: String) {

    fun cancelOrder(store: Store, order: Order) {
        store.markOrderCancelled(order)
    }

    override fun toString(): String {
        return  """
          Name: $name
          Phone: $tel
                """
    }

}