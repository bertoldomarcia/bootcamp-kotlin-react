package app

import model.Todo
import react.*
import react.dom.*

interface Props: RProps {
    var todos: List<Todo>
}


class TodoList : RComponent<Props, RState>() {

    override fun RBuilder.render() {
        ul(classes = "todo-list") {
            props.todos.mapIndexed({ index, todo ->
                li {
                    div ("view") {
                        label {
                            +todo.title
                        }
                    }
                }
            })
        }
    }
}

fun RBuilder.todoList(todos: List<Todo>) = child(TodoList::class) {
    attrs.todos = todos
}