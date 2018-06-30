package app

import model.Todo
import react.*
import react.dom.*

interface State: RState {
    var todos: List<Todo>
}


class App : RComponent<RProps, State>() {

    init {
        state.todos = listOf(
            Todo(title = "Teste 1"),
            Todo(title = "Teste 2")
        )
    }

    fun loadTodos(): List<Todo> {
        return listOf (
            Todo(title = "Teste 1"),
            Todo(title = "Teste 2")
        )
    }

    fun createTodo(todo: Todo) {
        val oldTodos = state.todos
        setState {
            todos = oldTodos + todo
        }
    }

    override fun RBuilder.render() {
        section("todoapp") {
            headerInput(::createTodo)

            section ("main") {
                todoList(state.todos)
            }


        }

    }
}
fun RBuilder.app() = child(App::class) {}




