import React from 'react';
import './TodoList.css';
import TodoNote from "../todo-note/TodoNote";
import {todoApi} from "../api/TodoApi";
import Header from "../todo-header/Header";
import {Field, reduxForm, reset} from "redux-form";
import Preloader from "../utils/Preloader";

const TodoList = React.memo(props => {

    let onClick = (data) => {
        todoApi.saveTodo(data.todoMessage).then(response => {
            if (response.status === 200) {
                props.props.addNote(response.data);
            }
        });
    };

    let deleteNote = (noteId) => {
        todoApi.deleteTodo(noteId).then(response => {
            if (response.status === 200) {
                props.props.deleteNote(noteId);
            }
        });
    };

    const notes = props.props.todo.notes.map(note =>
        (<TodoNote note={note.note} key={note.id} delete={() => deleteNote(note.id)}/>));

    return (
        <div>
            <Header/>
            <div className="todo-list">
                <TodoFormRedux onSubmit={onClick}/>
                {props.props.todo.isReady ?
                    <div className="todo-notes">
                        {notes}
                    </div> : <Preloader/>}
            </div>
        </div>
    )
});

function TodoForm(props) {
    return (
        <form onSubmit={props.handleSubmit}>
            <Field placeholder={"Enter text"} component={"input"} className="todo-input" name={"todoMessage"}/>
            <button type="submit" className="todo-button">Add</button>
        </form>
    )
}

const afterSubmit = (result, dispatch) => dispatch(reset("todo"));

const TodoFormRedux = reduxForm({form: "todo", onSubmitSuccess: afterSubmit})(TodoForm);

export default TodoList;