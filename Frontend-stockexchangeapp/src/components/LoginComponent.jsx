import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";



const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        Bu alanı doldurunuz !
      </div>
    );
  }
};

export default class Login extends Component {
  constructor(props) {
    super(props);
    

    this.state = {
      username: "",
      userPassword: "",
      loading: false,
      message: ""
    };
  }

 

  render() {
    return (
      <div className="card col-lg-6 offset-lg-3" style = {{borderColor:"#B22222"}}>
        <div className="card card-container">
          <Form
            onSubmit={this.handleLogin}
            ref={c => {
              this.form = c;
            }}
          >
            <div className="form-group">
              <label htmlFor="username">Kullanıcı Adı:</label>
              <Input
                type="text"
                className="form-control"
                name="username"
                value={this.state.username}
                onChange={this.onChangeUsername}
                validations={[required]}
              />
            </div>

            <div className="form-group">
              <label htmlFor="userPassword">Şifre:</label>
              <Input
                type="password"
                className="form-control"
                name="userPassword"
                value={this.state.password}
                onChange={this.onChangePassword}
                validations={[required]}
              />
            </div>

            <div className="form-group">
              <button
                className="btn btn-primary btn-block " style={{ margin: "10px 0px 15px 5px" }}
                disabled={this.state.loading}
              >
                {this.state.loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>Giriş</span>
              </button>
            </div>

            {this.state.message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert">
                  {this.state.message}
                </div>
              </div>
            )}
            <CheckButton
              style={{ display: "none" }}
              ref={c => {
                this.checkBtn = c;
              }}
            />
          </Form>
        </div>
      </div>
    );
  }
  }
