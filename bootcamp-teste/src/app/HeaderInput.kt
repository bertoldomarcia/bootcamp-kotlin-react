package app

import kotlinx.html.InputType
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.dom.header
import react.dom.input
import util.translate

class HeaderInput : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        header ("header") {
            h1{
                +"todos".translate()
            }
            input(classes = "new-todo", type = InputType.text) {
                attrs {
                    autoFocus = true
                    placeholder = "What needs to be done?"
                }
            }
        }
    }
}



fun RBuilder.headerInput() = child(HeaderInput::class) {}