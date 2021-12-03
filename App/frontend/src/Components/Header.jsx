import React from "react";

class Header extends React.Component {
    
    
    render() {
        return (
            <div className = "header">
                <div className="title">
                    <h1>Votesphere</h1>
                </div>
                    <div className="login"><a href={this.props.link}>{ this.props.text }</a></div>
            </div>
        )
    }

    
 
}

export default Header;