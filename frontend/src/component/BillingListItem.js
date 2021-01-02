import React from 'react';

function BillingListItem({billId, arrive, leave, firstName, surName, numberOfDays, totalAmount}){
    return (
        <span>({billId}, {arrive}, {leave}, {firstName}, {surName}, {numberOfDays}, {totalAmount})</span>
    );
}

export default BillingListItem;
