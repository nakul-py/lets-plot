package jetbrains.datalore.base.registration

abstract class Registration : Disposable {

    private var myRemoved: Boolean = false

    protected abstract fun doRemove()

    //this method should never be overridden except in Registration.EMPTY
    open fun remove() {
        if (myRemoved) {
            throw IllegalStateException("Registration already removed")
        }
        myRemoved = true
        doRemove()
    }

    override fun dispose() {
        remove()
    }

    private class EmptyRegistration internal constructor() : Registration() {

        override fun doRemove() {}

        override fun remove() {}
    }

    companion object {
        val EMPTY: Registration = EmptyRegistration()

        fun from(disposable: Disposable): Registration {
            return object : Registration() {
                override fun doRemove() {
                    disposable.dispose()
                }
            }
        }

        fun from(vararg disposables: Disposable): Registration {
            return object : Registration() {
                override fun doRemove() {
                    for (d in disposables) {
                        d.dispose()
                    }
                }
            }
        }
    }
}