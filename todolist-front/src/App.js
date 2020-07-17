import React from 'react';
import './App.css';
import TodoListContainer from "./components/todo-list/TodoListContainer";
import {Route} from "react-router-dom";
import Login from "./components/Login";

function App() {
    return (
        <div className="app-wrapper">
            <Route path="/login" component={() => <Login/>}/>
            <Route exact path="/todo" component={() => <TodoListContainer/>}/>
        </div>
    );
}

export default App;
