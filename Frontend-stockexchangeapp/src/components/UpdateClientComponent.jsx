import React, { Component } from 'react';
import AdminService from '../services/AdminService';

class UpdateClientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            userEmail: '',
            userType: '',
            userName: '',
            userPassword: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.updateClient = this.updateClient.bind(this);
    }
    
    componentDidMount() {
        AdminService.getClientById(this.state.id).then((res) => {
            let client = res.data;
            this.setState({
                firstName: client.firstName, lastName: client.lastName, userEmail: client.userEmail,
                userType: client.userType, userName: client.userName, userPassword: client.userPassword
            });
        });
    }
    updateClient = (e) => {
        e.preventDefault();
        let client = {
            firstName: this.state.firstName, lastName: this.state.lastName,
            userEmail: this.state.userEmail, userType: this.state.userType, userName: this.state.userName,
            userPassword: this.state.userPassword
        };
        console.log('client =>' + JSON.stringify(client));
        AdminService.updateClient(this.state.id,client).then((res)=> {
            this.props.history.push('/admin/clients');
        })
        
    }

    cancel() {
        this.props.history.push('/admin/clients')
    }

    changeFirstNameHandler = (event) => {
        this.setState({ firstName: event.target.value });
    }
    changeLastNameHandler = (event) => {
        this.setState({ lastName: event.target.value });
    }
    changeUserEmailHandler = (event) => {
        this.setState({ userEmail: event.target.value });
    }
    changeUserTypeHandler = (event) => {
        this.setState({ userType: event.target.value });
    }
    changeUserNameHandler = (event) => {
        this.setState({ userName: event.target.value });
    }
    changeUserPasswordHandler = (event) => {
        this.setState({ userPassword: event.target.value });
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-lg-6 offset-lg-3" style = {{borderColor:"#B22222"}} >
                            <h3 className="text-center">Kullanıcı Güncelle</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>İsim:</label>
                                        <input placeholder="İsim" name="firstName" className="form-control"
                                            value={this.state.firstName} onChange={this.changeFirstNameHandler} required />
                                    </div>
                                    <div className="form-group">
                                        <label>Soyisim:</label>
                                        <input placeholder="Soyisim" name="lastName" className="form-control"
                                            value={this.state.lastName} onChange={this.changeLastNameHandler} required />
                                    </div>
                                    <div className="form-group">
                                        <label>Email:</label>
                                        <input placeholder="Email" name="userEmail" className="form-control"
                                            value={this.state.userEmail} onChange={this.changeUserEmailHandler} required />
                                    </div>
                                    <div className="form-group">
                                        <label>Kullanıcı Tipi:</label>
                                        <input placeholder="Kullanıcı Tipi" name="userType" className="form-control"
                                            value={this.state.userType} onChange={this.changeUserTypeHandler} required />
                                    </div>
                                    <div className="form-group">
                                        <label>Kullanıcı İsmi:</label>
                                        <input placeholder="Kullanıcı İsmi" name="userName" className="form-control"
                                            value={this.state.userName} onChange={this.changeUserNameHandler} required />
                                    </div>
                                    <div className="form-group">
                                        <label>Şifre:</label>
                                        <input placeholder="Şifre" name="userPassword" className="form-control"
                                            value={this.state.userPassword} onChange={this.changeUserPasswordHandler} required />
                                    </div>
                                    <button className="btn btn-danger btn-sm" onClick={this.cancel.bind(this)} style={{ margin: "10px 10px 15px 5px" }}>İptal</button>
                                    <button className="btn btn-success btn-sm" onClick={this.updateClient} style={{ margin: "10px 0px 15px 5px" }}>Güncelle</button>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}

export default UpdateClientComponent;