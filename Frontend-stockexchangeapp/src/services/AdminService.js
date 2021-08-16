import axios from 'axios';

const ADD_CLIENT_API_BASE_URL ="http://localhost:8080/api/admin/addClient"
const ADD_STOCK_API_BASE_URL ="http://localhost:8080/api/admin/addStock"
const CLIENT_API_BASE_URL = "http://localhost:8080/api/admin/clients"
const CLIENT_USERNAME_API_BASE_URL = "http://localhost:8080/api/admin/clientUsername"
const STOCK_API_BASE_URL = "http://localhost:8080/api/admin/stocks"

class AdminService {

    getClients(){
        return axios.get(CLIENT_API_BASE_URL);
    }

    addClient(client){
        return axios.post(ADD_CLIENT_API_BASE_URL,client);
    }

    getClientById(clientId){
        return axios.get(CLIENT_API_BASE_URL + '/' + clientId);
    }

    getClientUsernameById(clientId){
        return axios.get(CLIENT_USERNAME_API_BASE_URL + '/' + clientId);
    }

    updateClient(clientId,client){
        return axios.put(CLIENT_API_BASE_URL + '/' + clientId,client);
    }

    deleteClient(clientId){
        return axios.delete(CLIENT_API_BASE_URL + '/' + clientId);
    }

    getStocks(){
        return axios.get(STOCK_API_BASE_URL);
    }

    addStock(stock){
        return axios.post(ADD_STOCK_API_BASE_URL,stock);
    }

    getStockById(stockId){
        return axios.get(STOCK_API_BASE_URL + '/' + stockId);
    }

    updateStock(stockId,stock){
        return axios.put(STOCK_API_BASE_URL + '/' + stockId,stock);
    }

    deleteStock(stockId){
        return axios.delete(STOCK_API_BASE_URL + '/' + stockId);
    }
}

export default new AdminService()