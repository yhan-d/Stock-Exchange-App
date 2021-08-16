import React, { Component } from 'react';
import AdminService from '../services/AdminService';


class CreateClientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            firstName: '',
            lastName: '',
            userEmail: '',
            userType: '',
            userName: '',
            userPassword: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.saveClient = this.saveClient.bind(this);
    }



    saveClient = (e) => {
        e.preventDefault();
        let client = { firstName: this.state.firstName, lastName: this.state.lastName, 
            userEmail: this.state.userEmail, userType: this.state.userType, userName: this.state.userName, 
            userPassword: this.state.userPassword }
            console.log('client =>' + JSON.stringify(client));
            AdminService.addClient(client).then(res => {
                this.props.history.push('/admin/clients');
            });
    }

    cancel(){
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
                            <h3 className="text-center">Kullanıcı Ekle</h3>
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
                                    <button className="btn btn-danger btn-sm" onClick={this.cancel.bind(this)} style={ {margin: "10px 10px 15px 5px"} }>İptal</button>
                                    <button className="btn btn-success btn-sm" onClick={this.saveClient} style={{ margin: "10px 0px 15px 5px"}}>Ekle</button>
                                    
                                </form>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}


export default CreateClientComponent;