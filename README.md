Made for the MAPD class at IMT Atlantique, DCL specialization.
### Authors
LERQUEMAIN Yann - yann.lerquemain@imt-atlantique.net\
RABILLOUD Quentin - quentin.rabilloud@imt-atlantique.net

# PetriNet
- Java implementation of a petri Net
- Transition centered petriNet.
- Run tests.PetriNetImplementationTest to test the methods.

## Modifications of conception :
- Removed association between EdgeIn and Place, EdgeOut and Place, and put the association directly between Edge and Place.
- Added an association between Edge and Transition.
- Added a place and transition attribute in Edge, to store origin and destination.
- Added specific constructos in EdgeIn, EdgeOut, and Place, according to use cases.
- Modified token manipulation in Place, to be more versatile and not require loops.
- Added equals override in Edge classes, to suit edge comparisons needs.
- Created a specific EdgeOut protected constructor, to avoid exception upon EdgeEmpty and EdgeZero creation (placeholder value caused error).

See the initial and latest class diagram in [conceptions.pdf](conceptions.pdf).\
See the final report (in french) on the work in [the report file](lerquemain_rabilloud.pdf).

# PNEditor (copy of the original README.md)

The original PNE can be downloaded from [www.pneditor.org](http://www.pneditor.org/)

This instance is the result of a student project by Joris Thaveau for teaching purpose.

It is a simplified Petri net editor that allows the editing of many PetriNet models.

To use:

1. Run org.pneditor.editor.Main as a Java application
2. Select the model used (the menu scans the org.pneditor.petrinet.adapters folder to build a list of available models and adapters). initial and imta are available. Places and transitions are displayed in different ways.
3. Edit the PetriNet and fire transitions.

You may experiment some unexpected exceptions. Especially if you mix models.

The pedagogical approach consists in:

1. Develop your own PetriNet model in an independent project/environment - with no GUI, just the ''business'' view
2. Pack it as a jar, and let it be visible in the path
3. Develop an Adapter in the org.pneditor.petrinet.adapters folder of PNE to make your model editable

The adapter may be simple or complex depending on the "distance" between your model and the one expected by PNE.

Code license: [GNU GPL v3](http://www.gnu.org/licenses/gpl.html)

Requirements: Java SE 8+