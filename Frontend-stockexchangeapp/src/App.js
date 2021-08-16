import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListClientComponent from './components/ListClientComponent';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import CreateClientComponent from './components/CreateClientComponent';
import UpdateClientComponent from './components/UpdateClientComponent';
import ListStockComponent from './components/ListStockComponent';
import CreateStockComponent from './components/CreateStockComponent';
import UpdateStockComponent from './components/UpdateStockComponent';


import LoginComponent from "./components/LoginComponent";






function App() {
  
  return (
  <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route exact path="/login" component={LoginComponent} />
            <Route path="/admin/clients" component={ListClientComponent}></Route>
            <Route path="/admin/addClient" component={CreateClientComponent}></Route>
            <Route path="/admin/updateClient/:id" component={UpdateClientComponent}></Route>
            <Route path="/admin/stocks" component={ListStockComponent}></Route>
            <Route path="/admin/addStock" component={CreateStockComponent}></Route>
            <Route path="/admin/updateStock/:id" component={UpdateStockComponent}></Route>
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>


  );
  
}



export default App;
