import React, { Component } from 'react';

class HeaderComponent extends Component {
    constructor(props){
        super(props)

        this.state = {

        }
    }
    
    
    
    render() {
        return (
            <div>
                <header>
                    <nav className = "navbar  navbar-light " style={{'backgroundColor': "#B22222"}}>
                        <div> 
                        <a href = "https://tr.linkedin.com/in/ya%C4%9F%C4%B1zhan-demirci-95382018b" className= "navbar-brand " > Stock Exchange App </a>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;