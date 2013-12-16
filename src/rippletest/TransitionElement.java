/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

/**
 *
 * @author Aaron
 */
public class TransitionElement {
    public VisualState state;
    float alpha;

    public TransitionElement(VisualState state, float alpha) {
        this.state = state;
        this.alpha = alpha;
    }
}
