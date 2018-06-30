package app

import kotlinx.html.js.onChangeFunction
import react.*
import react.dom.*
import logo.*
import ticker.*

class App : RComponent<RProps, App.State>() {

    class State(var inputValue: String) : RState

    override fun componentWillMount() {
        setState {
            state.inputValue = "Input your name"
        }
    }


    override fun RBuilder.render() {

        h1 {
            +"Hello Bootcamp"
        }


        div("App-header") {
            input {
                attrs {
                    value = state.inputValue
                    onChangeFunction =  { event ->
                        val value = event.currentTarget.asDynamic().value
                        setState {
                            inputValue = value
                        }

                    }
                }
            }
        }

        div {
            span {
                +state.inputValue
            }
        }

    }
}

fun RBuilder.app() = child(App::class) {}
