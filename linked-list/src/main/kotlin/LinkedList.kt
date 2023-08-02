class Deque<T> {

    var value : T? = null
    var next: Deque<T>? = null
    var prev: Deque<T>? = null
    fun push(value: T) {
        this.value?.let{
            next = Deque<T>()
            next!!.push(it)
            next!!.prev = this
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
        return (this.next?.unshift(value)?:let{
            this.value?.let {  this.next = Deque()
                this.next!!.value=value
                this.next!!.prev=this }
        })?:run{this.value = value}
    }

    fun shift(): T? {
        return this.next?.shift()?:run{
            prev?.next = null
            value
        }

    }


    override fun toString() = ((value?.toString()?:" ") + " " + (next?.value?.toString()?:" ")).trim()
}

