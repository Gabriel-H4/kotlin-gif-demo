class InputHandler(private val store: Store) {

    private var doLoop = true

    private fun greet() {
        println("""
                --------------------------
                --- Welcome to GIF 9.0 ---
                -- Developed by Gabriel --
                --------------------------
                """.trimIndent())
    }

    private fun leave() {
        println("""
                --------------------------
                -----  Goodbye now!  -----
                --------    :)    --------
                --------------------------
                """.trimIndent())
        doLoop = false
    }

    private fun mainMenu() {
        println("""
            
                Select an option:
                1. View all Tote IDs
                2. View all Active OSNs
                3. View all Past OSNs
                4. Get customer info
                5. Generate OSN
                6. Generate Tote ID
                7.
                8. Greet
                9. Exit
                100. genDebugInfo
                """.trimIndent())
        when(getInt(readln())) {
            1 -> println(store.allToteIDs.joinToString())
            2 -> println(store.getOSNFromPredicate(false).joinToString())
            3 -> println(store.getOSNFromPredicate(true).joinToString())
            // TODO("Modify hard-coded false predicate below to be user-input Boolean")
            4 -> {
                println("Only show past customers? true / false")
                println(store.getCustomerList(getBool(readln())).joinToString("").trimIndent())
            }
            5 -> println(store.assignOSN())
            6 -> println(store.assignToteID())
            8 -> greet()
            9 -> leave()
            100 -> genDebugInfo()
            else -> {
                println("Invalid number specified")
            }
        }
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

    private fun getInt(input: String): Int {
        return input.toIntOrNull() ?: 0
    }

    private fun getBool(input: String): Boolean {
        return input.toBooleanStrictOrNull() ?: false
    }

    fun runLoop() {
        greet()
        while(doLoop) {
            mainMenu()
        }
    }

}