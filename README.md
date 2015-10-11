# GeneBurst

Contributors: James Barbour, [Scott Emmons](http://scottemmons.com/), Luke Tannenbaum

Determining microbial community composition is a fundamental problem in ecology. Researchers spend years planning, funding, and executing expeditions to remote locations of the globe to collect samples for study. After extracting DNA samples in the lab, researchers use open-source software tools, such as [Qiime](http://qiime.org/), to process their DNA sequencing data. While such software efficiently processes the data, researchers are left with the challenge of interpreting it -- rows upon rows of numbers.

GeneBurst, acting as a direct Qiime to [D3.js](http://d3js.org/) converter, meets the cyberinfrastructure needs of biological researchers. It takes the raw CSV data that Qiime outputs and convertes it to a JSON file that can be passed into our D3.js sunburst visualization. A sunburst, which depicts the community composition of an individual location, has a hierarchical structure; as the burst progresses radially outward, it increases in taxonomic resolution. The size of each sunburst arc encodes the given taxonomic unit's percentage by biomass of a community. For our example visualization, we've used data from an Antarctic research project by the Arnosti lab of UNC Marine Sciences.

[geneburst.jebarb.com](http://geneburst.jebarb.com)
