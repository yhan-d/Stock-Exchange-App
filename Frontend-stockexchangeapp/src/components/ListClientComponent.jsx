import React, { Component } from 'react';
import AdminService from '../services/AdminService'

class ListClientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

            clients: []

        }
        this.addClient = this.addClient.bind(this);
        this.updateClient = this.updateClient.bind(this);
        this.deleteClient =this.deleteClient.bind(this);
    }

    deleteClient(id){
        AdminService.deleteClient(id).then(res => {
            this.setState({clients: this.state.clients.filter(client => client.userId !== id)});
        });
    }

    updateClient(id){
        this.props.history.push(`/admin/updateClient/${id}`);
    }

    componentDidMount() {
        AdminService.getClients().then((res) => {

            this.setState({ clients: res.data });

        });
    }

    addClient() {
        this.props.history.push('/admin/addClient');
    }

    render() {
        return (
            <div>

                <h2 className="text-center" > Kullanıcı Listesi </h2>
                <div >
                    <button className="btn btn-dark btn-sm" onClick={this.addClient} style={{backgroundColor: "#B22222"}}>Kullanıcı Ekle</button>
                </div>
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>İsim</th>
                                <th>Soyisim</th>
                                <th>Email </th>
                                <th>Kullanıcı Tipi</th>
                                <th>Kullanıcı İsmi</th>
                                <th>Şifre</th>
                                <th>Düzenleme</th>

                            </tr>

                        </thead>

                        <tbody>{
                            this.state.clients.map(
                                client =>
                                    <tr key={client.userId}>
                                        <td>{client.firstName}</td>
                                        <td>{client.lastName}</td>
                                        <td>{client.userEmail}</td>
                                        <td>{client.userType}</td>
                                        <td>{client.userName}</td>
                                        <td>{client.userPassword}</td>
                                        <td>
                                            <button onClick = { () => this.updateClient(client.userId)} className="btn btn-info">Güncelle</button>
                                            <button  style={{ marginLeft: "20px"}} onClick = { () => this.deleteClient(client.userId)} className="btn btn-danger">Sil</button>
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

export default ListClientComponent;