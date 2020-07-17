import axios from "axios";

const baseUrl = "http://localhost:8080/api/todo/";

export const todoApi = {
    getTodo() {
        return axios.get(baseUrl);
    },
    deleteTodo(noteId) {
        return axios.delete(baseUrl + noteId);
    },
    saveTodo(note) {
        return axios.post(baseUrl, {note: note});
    }
};
