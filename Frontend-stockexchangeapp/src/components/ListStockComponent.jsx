import React, { Component } from 'react';
import AdminService from '../services/AdminService'

class ListStockComponent extends Component {
    constructor(props) {
        super(props)
        
        this.state = {
            
            stocks: []

        }
        this.addStock = this.addStock.bind(this);
        this.updateStock = this.updateStock.bind(this);
        this.deleteStock =this.deleteStock.bind(this);
    }

    deleteStock(id){
        AdminService.deleteStock(id).then(res => {
            this.setState({stocks: this.state.stocks.filter(stock => stock.stockId !== id)});
        });
    }

    updateStock(id){
        this.props.history.push(`/admin/updateStock/${id}`);
    }

   
   
    


    componentDidMount() {
        AdminService.getStocks().then((res) => {

            this.setState({ stocks: res.data });

        });
    }

    

    addStock() {
        this.props.history.push('/admin/addStock');
    }

    render() {
        return (
            <div>

                <h2 className="text-center" > Hisse Senedi Listesi </h2>
                <div >
                    <button className="btn btn-dark btn-sm" onClick={this.addStock} style={{backgroundColor: "#B22222"}}>Hisse Senedi Ekle</button>
                </div>
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Kod</th>
                                <th>İsim</th>
                                <th>Ücret </th>
                                <th>Tarih</th>
                                <th>Düzenleme</th>
                            </tr>
                        </thead>
                        <tbody>{
                            this.state.stocks.map(
                                stock =>
                                    <tr key={stock.stockId}>
                                        <td>{stock.stockCode}</td>
                                        <td>{stock.stockName}</td>
                                        <td>{getStockValue()}</td>
                                        <td>{getStockDate()}</td>
                                        <td>
                                            <button onClick = { () => this.updateStock(stock.stockId)} className="btn btn-info">Güncelle</button>
                                            <button style={{ marginLeft: "20px"}} onClick = { () => this.deleteStock(stock.stockId)} className="btn btn-danger">Sil</button>
                                        </td>

                                    </tr>
                            )



                        }
                        </tbody>

                    </table>

                </div>
                

            </div>
        );
    }
}

function getStockValue(){
    return  Math.floor(Math.random() * 300) + 1 + " TRY";
  }
  function getStockDate() {
    return new Date().toLocaleString();
  }
  

export default ListStockComponent;