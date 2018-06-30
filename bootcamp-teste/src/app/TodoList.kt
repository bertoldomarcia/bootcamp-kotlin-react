package app

import model.Todo
import react.*
import react.dom.*

interface Props: RProps {
    var todos: List<Todo>
    var removeTodo: (Todo) -> Unit
}


class TodoList : RComponent<Props, RState>() {

    override fun RBuilder.render() {
        ul(classes = "todo-list") {
            props.todos.mapIndexed({ index, todo ->
                li {
                    todoItem(todo, props.removeTodo)
                }
            })
        }
    }
}

fun RBuilder.todoList(todos: List<Todo>, removeTodo: (Todo) -> Unit) = child(TodoList::class) {
    attrs.todos = todos
    attrs.removeTodo = removeTodo
}