import {combineReducers, createStore} from "redux";
import {todoListReducer} from "./reducers/todoListReducer";
import {reducer as formReducer} from 'redux-form';

let reducers = combineReducers({
    todo: todoListReducer,
    form: formReducer
});

let store = createStore(reducers);

export default store;