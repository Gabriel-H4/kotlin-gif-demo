class InputHandler2(private val store: Store2) {

    fun greet() {
        println("""
                --------------------------
                --- Welcome to GIF 9.0 ---
                -- Developed by Gabriel --
                --------------------------
                """.trimIndent())
    }

    fun leave() {
        println("""
                --------------------------
                -----  Goodbye now!  -----
                --------    :)    --------
                --------------------------
                """.trimIndent())
    }

    fun mainMenu() {
        println("\nSelect an option: ")
        println("0. View all Tote IDs")
        println("1. View all Active OSNs")
        println("2. View all Past OSNs")
        println("3. Get customer info")
        println("4. Generate Tote ID")
        println("8. Greet")
        println("9. Exit")
        println("100. genDebugInfo")
        requestHandler(readln(), ParseSystem.NUMERICAL)
    }

    private fun genDebugInfo() {
        println("--------------------------")
        println("----- Store # ${store.storeNumber} -------")
        println("----- Store Tote IDs -----")
        println(store.allToteIDs.joinToString())
        println("----- Active Orders ------")
        println(store.getOrdersFromPredicate(false).joinToString("\n"))
        println("------ Past Orders -------")
        println(store.getOrdersFromPredicate(true).joinToString("\n"))
        println("----- Generated OSN: -----")
        println(store.assignOSN())
        println("--- Generated Tote ID: ---")
        println(store.assignToteID())

        println("--------------------------")
    }

    private enum class ParseSystem {
        NUMERICAL, ALPHANUMERICAL, BOOLEAN
    }

    private fun requestHandler(input: String, context: ParseSystem) {
        if(context == ParseSystem.NUMERICAL) {
            val userInputConverted = input.toIntOrNull()?.also { selection ->
                when(selection) {
                    0 -> println(store.allToteIDs.joinToString())
                    1 -> println(store.getOSNFromPredicate(false).joinToString())
                    2 -> println(store.getOSNFromPredicate(true).joinToString())
                    // TODO("Modify hard-coded false predicate below to be user-input Boolean")
                    3 -> {
                        println("Only show past customers? true / false")
                        requestHandler(readln(), ParseSystem.BOOLEAN)
                    }
                    4 -> println(store.assignToteID())
                    8 -> greet()
                    9 -> leave()
                    100 -> genDebugInfo()
                    else -> {
                        println("Invalid number specified")
                    }
                }
            } ?: run {
                println("Invalid input: Only choose a number")
            }
        }
        else if(context == ParseSystem.ALPHANUMERICAL) {
            println("You input a String reply: $input")
        }
        else {
            val userInputConverted = input.toBooleanStrictOrNull()
            println("You input a Boolean reply: $input")

        }
    }

}