package app

import model.Todo
import react.*
import react.dom.*

interface Props: RProps {
    var todos: List<Todo>
    var removeTodo: (Todo) -> Unit
    var updateTodo: (Todo) -> Unit
}


class TodoList : RComponent<Props, RState>() {

    override fun RBuilder.render() {
        ul(classes = "todo-list") {
            props.todos.mapIndexed({ index, todo ->
                val classes = when {
                    todo.completed -> "completed"
                    else -> ""
                }
                li (classes = classes) {
                    todoItem(todo, props.removeTodo, props.updateTodo)
                }
            })
        }
    }
}

fun RBuilder.todoList(todos: List<Todo>, removeTodo: (Todo) -> Unit, updateTodo: (Todo) -> Unit) = child(TodoList::class) {
    attrs.todos = todos
    attrs.removeTodo = removeTodo
    attrs.updateTodo = updateTodo
}