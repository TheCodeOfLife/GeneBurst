# GeneBurst

Contributors: James Barbour, [Scott Emmons](http://scottemmons.com/), Luke Tannenbaum

GeneBurst is a direct [Qiime](http://qiime.org/) to [D3.js](http://d3js.org/) converter. It takes the raw CSV data from Qiime and convertes it to a JSON file that can be passed into our D3.js Sunburst visualization. For our example visualization, we've used data from an Antarctic research project by the Arnosti lab of UNC Marine Sciences. Each individual sunburst has a inward-outward structure that represents the taxonomy of organisms gathered from a specific site. The size of a given section represents the percentage of the site's biomass comprised of a given taxonomic classification.

The framework of GeneBurst is designed to be extensible and versatile and will continue to be in active development after HackNC. The goal is to provide a push-button solution for data visualization for Qiime and other lab software that is freely available under the GPL.

[geneburst.jebarb.com](http://geneburst.jebarb.com)
