const ADD_NOTES = "ADD_NOTES";
const DELETE_NOTE = "DELETE_NOTE";
const SET_STATE = "SET_STATE";
const SET_DATA_READY = "SET_DATA_READY";

export const addNoteAC = (note) => {
    return {
        type: ADD_NOTES,
        note
    }
};

export const deleteNoteAC = (noteId) => {
    return {
        type: DELETE_NOTE,
        noteId: noteId
    }
};

export const readyAC = () => {
    return {
        type: SET_DATA_READY
    }
};

export const setStateAC = (state) => {
    return {
        type: SET_STATE,
        state: state
    }
};

let initialiseStore = {
    notes: [],
    isReady: false
};

export let todoListReducer = (state = initialiseStore, action) => {
    let copyState = {...state};
    if (action.type === ADD_NOTES && action.note.note !== "") {
        copyState.notes.push({
            id: action.note.id,
            note: action.note.note
        });
    } else if (action.type === DELETE_NOTE) {
        copyState.notes = copyState.notes.filter(note => note.id !== action.noteId);
    } else if (action.type === SET_STATE) {
        copyState.notes = action.state;
    } else if (action.type === SET_DATA_READY) {
        copyState.isReady = true;
    }
    return copyState;
};