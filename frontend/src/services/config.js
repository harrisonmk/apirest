import axios from 'axios';

export const http = axios.create({
baseURL: 'https://apirestspringboot.herokuapp.com/api/',
});
