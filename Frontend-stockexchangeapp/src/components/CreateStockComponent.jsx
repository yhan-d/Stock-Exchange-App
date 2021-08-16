import React, { Component } from 'react';
import AdminService from '../services/AdminService';


class CreateStockComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            stockCode: '',
            stockName: '',
        }
        this.changeStockCodeHandler = this.changeStockCodeHandler.bind(this);
        this.changeStockNameHandler = this.changeStockNameHandler.bind(this);
        this.saveStock = this.saveStock.bind(this);
    }



    saveStock = (e) => {
        e.preventDefault();
        let stock = { stockCode: this.state.stockCode, stockName: this.state.stockName }
            console.log('stock =>' + JSON.stringify(stock));
            AdminService.addStock(stock).then((res) => {
                this.props.history.push('/admin/stocks');
            });
    }

    cancel(){
        this.props.history.push('/admin/stocks')
    }

    changeStockCodeHandler = (event) => {
        this.setState({ stockCode: event.target.value });
    }
    changeStockNameHandler = (event) => {
        this.setState({ stockName: event.target.value });
    }
    render() {
        return (
            <div>
                <div className="container-fluid">
                    <div className="row">
                        <div className="card col-lg-6 offset-lg-3" style = {{borderColor:"#B22222"}}> 
                            <h3 className="text-center">Hisse Senedi Ekle</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Kod:</label>
                                        <input placeholder="Kod" name="stockCode" className="form-control"
                                            value={this.state.stockCode} onChange={this.changeStockCodeHandler} required />
                                    </div>
                                    <div className="form-group">
                                        <label>İsim:</label>
                                        <input placeholder="İsim" name="stockName" className="form-control"
                                            value={this.state.stockName} onChange={this.changeStockNameHandler} required />
                                    </div>
                                    <button className="btn btn-danger btn-sm" onClick={this.cancel.bind(this)} style={ {margin: "10px 10px 15px 5px"} }>İptal</button>
                                    <button className="btn btn-success btn-sm" onClick={this.saveStock} style={{ margin: "10px 0px 15px 5px"}}>Ekle</button>
                                    
                                </form>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}


export default CreateStockComponent;