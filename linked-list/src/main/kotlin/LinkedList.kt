class Deque<T> {

    var value : T? = null
    var next: Deque<T>? = null
    fun push(value: T) {
        this.value?.let{
            next = Deque<T>()
            next!!.push(it)
        }
        this.value = value
    }

    fun pop(): T? {
        val value = this.value
        this.value = this.next?.value
        this.next = this.next?.next
        return value
    }


    fun unshift(value: T) {
        TODO("Implement this function to complete the task")
    }

    fun shift(): T? {
        TODO("Implement this function to complete the task")
    }
    override fun toString() = ((value?.toString()?:" ") + " " + (next?.value?.toString()?:" ")).trim()
}

