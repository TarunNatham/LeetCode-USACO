/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */

var coinChange = function(coins, amount, memo = {}) {
        const table = Array(amount + 1).fill(-1);
        table[0] = 0;
        for(let i = 0; i <= amount; i++) {
            if(table[i] !== -1) {
                for(let coin of coins) {
                    const current = table[i] + 1;
                    if(table[i + coin] === -1 || current < table[i + coin]) {
                        table[i + coin] = current;
                    }
                }
            }
        }
        return table[amount];
};