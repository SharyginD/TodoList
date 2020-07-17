import React, {PureComponent} from 'react';
import {addNoteAC, deleteNoteAC, readyAC, setStateAC} from "../../redux/reducers/todoListReducer";
import TodoList from "./TodoList";
import {connect} from "react-redux";
import {todoApi} from "../api/TodoApi";
import {getTodo} from "../selectors/TodoSelector";

class TodoListContainer extends PureComponent {

    componentDidMount() {
        todoApi.getTodo().then(response => {
            this.props.setNotes(response.data);
            this.props.setReady();
        });
    }

    render() {
        return (
            <div>
                <TodoList props={this.props}/>
            </div>
        );
    }
}

let mapStateToProps = (state) => {
    return {
        todo: getTodo(state)
    }
};

let mapDispatchToProps = (dispatch) => {
    return {
        addNote: (note) => {
            dispatch(addNoteAC(note));
        },
        deleteNote: (noteId) => {
            dispatch(deleteNoteAC(noteId));
        },
        setNotes: (state) => {
            dispatch(setStateAC(state));
        },
        setReady: () => {
            dispatch(readyAC());
        }
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(TodoListContainer);