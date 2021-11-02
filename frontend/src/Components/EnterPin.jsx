import React from "react";
import PollUserService from "../Service/PollUserService";

const EnterPin = () => {
    /*
    constructor(props) {
        super(props);
        this.state = {pollusers: []}
    }

    getData = () => {
        PollUserService.getPollUser()
        .then(([userRes]) => {
            this.setState({
                pollusers: userRes.data
            })
        })
    }

    componentDidMount() {
        this.getData();
    }
    */
    return (
    <div className="inputDiv">
        <p>Get your voting on! </p>
        <input className="pinInput" type="text" placeholder="Enter pin..."/>
        <p>{PollUserService.getPollUser()}</p>
    </div>
    );
}

export default EnterPin;