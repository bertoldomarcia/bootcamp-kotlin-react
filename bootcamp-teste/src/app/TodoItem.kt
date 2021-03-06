package app

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import model.Todo
import react.*
import react.dom.*



class TodoItem : RComponent<TodoItem.Props, RState>() {

    override fun RBuilder.render() {
        div ("view"){

            input(classes ="toggle", type=InputType.checkBox) {
                attrs {
                    onChangeFunction = { event ->
                        val checked = event.currentTarget.asDynamic().checked as Boolean
                        props.updateTodo(props.todo.copy( completed = checked))
                    }

                    ref { it?.checked = props.todo.completed}
                }
            }

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

    class Props(var todo: Todo, var removeTodo: (Todo) -> Unit, var updateTodo: (Todo) -> Unit) : RProps
}

fun RBuilder.todoItem(todo: Todo, removeTodo: (Todo) -> Unit, updateTodo: (Todo) -> Unit) = child(TodoItem::class) {
    attrs.todo = todo
    attrs.removeTodo = removeTodo
    attrs.updateTodo = updateTodo
}