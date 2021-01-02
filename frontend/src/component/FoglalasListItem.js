import React from 'react';

function FoglalasListItem({foglalasId, cellaszam, erkezes, tavozas, vezeteknev, keresztnev, telefonszam, tipus, aram }){
    return (
        <span>({foglalasId}, {cellaszam}, {erkezes}, {tavozas}, {vezeteknev}, {keresztnev}, {telefonszam}, {tipus}, {aram})</span>
    );
}

export default FoglalasListItem;
