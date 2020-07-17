import React from 'react';
import "./TodoNote.css";

function TodoNote(props) {
    return (
        <div className="todo-note">
            <p>{props.note} {props.id}</p>
            <button onClick={props.delete}>Delete</button>
        </div>
    )
}

export default TodoNote