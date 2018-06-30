package app

import kotlinx.html.js.onClickFunction
import model.Todo
import react.*
import react.dom.*



class TodoItem : RComponent<TodoItem.Props, RState>() {

    override fun RBuilder.render() {
        div ("view"){
            label {
                +props.todo.title
            }
            button(classes= "destroy") {
                attrs {
                    onClickFunction = {
                        props.removeTodo(props.todo)
                    }
                }
            }
        }
    }

    class Props(var todo: Todo, var removeTodo: (Todo) -> Unit) : RProps
}

fun RBuilder.todoItem(todo: Todo, removeTodo: (Todo) -> Unit) = child(TodoItem::class) {
    attrs.todo = todo
    attrs.removeTodo = removeTodo
}