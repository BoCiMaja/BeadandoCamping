import React from 'react';
import './App.scss';
import FoglalasRecordingForm from "./component/FoglalasRecordingForm";
import FoglalasList from "./component/FoglalasList";

function App() {
  return (
    <div className={["App","container"]}>
        <div className={"row"}>
            <div className={"col-md-3"}></div>
            <div className={"col-md-6"}>
                <FoglalasRecordingForm/>
                <FoglalasList/>
            </div>
            <div className={"col-md-3"}></div>
        </div>
    </div>
  );
}

export default App;
