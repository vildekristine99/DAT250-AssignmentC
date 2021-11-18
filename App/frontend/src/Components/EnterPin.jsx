import React from "react";
import PollUserService from "../Service/PollUserService.js";
import PollUsers from "../API/PollUsers.js";

//class EnterPin extends React.Component {

    const EnterPin = () => {
        return (
            <div className="inputDiv">
                <p>Get your voting on! </p>
                <input className="pinInput" type="text" placeholder="Enter pin..."/>
                <PollUsers></PollUsers>
            </div>
        )
    }
    
export default EnterPin;