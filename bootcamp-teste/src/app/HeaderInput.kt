package app

import kotlinx.html.InputType
import model.Todo
import react.*
import react.dom.h1
import react.dom.header
import react.dom.input
import util.translate

class HeaderInput : RComponent<HeaderInput.Props, HeaderInput.State>() {

    override fun componentWillMount() {
        setState {
            title = ""
        }
    }

    override fun RBuilder.render() {
        header ("header") {
            h1{
                +"todos".translate()
            }
            input(classes = "new-todo", type = InputType.text) {
                attrs {
                    autoFocus = true
                    placeholder = "What needs to be done?"

                    value = state.title
                }
            }
        }
    }

    class Props(var createTodo: (Todo) -> Unit) : RProps
    class State(var title: String) : RState
}



fun RBuilder.headerInput(createTodo: (Todo) -> Unit) = child(HeaderInput::class) {
    attrs.createTodo = createTodo
}